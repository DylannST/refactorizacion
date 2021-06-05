import React, {
  useContext,
  useRef,
  useState
} from "react";

import Store from "./Store";

const HOST_API = "http://localhost:8080/api";


const FormList = () => {
  const { dispatch } = useContext(Store);
  const formRef = useRef(null);
  const [state, setState] = useState({ name: "" });

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
    };

    fetch(HOST_API + "/ListTodos", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "add-item-group", todoLists: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return (
      <form ref={formRef}>
        <input
          type="text"
          name="name"
          placeholder="Lista"
          onChange={(event) => {
            setState({ name: event.target.value });
          }}
        ></input>
        <button onClick={onAdd}>Nueva lista</button>
      </form>

  );
};

export default FormList;
