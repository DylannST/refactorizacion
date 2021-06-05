import { isEmpty, map, size } from "lodash";
import React, { useContext, useEffect, useState } from "react";
import Store from "./Store";

const HOST_API = "http://localhost:8080/api";

const ListTodo = ({ idListTodo, index, change, sizes }) => {
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  // const currentList = []; //.item.map((item) => item.id == idListTodo);
  const [currentList, setCurrentList] = useState([]);

  useEffect(() => {
    // if(!isEmpty(idListTodo))
    // console.log("sirvaa")
    fetch(HOST_API + "/" + idListTodo + "/todofk")
      .then((response) => response.json())
      .then((list) => {
        if (!isEmpty(list)) {
          console.log(list)
          dispatch({
            type: "get-todos-by-id",
            listTodo: list,
            index: index,
            size: sizes,
          });
          console.log(todo);
          setCurrentList(todo.item[index]);
        }

        //currentList = todo.item.map((item) => item.id == idListTodo);
      });
  }, [dispatch, change]);

  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todo", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-item", id: id, index: index });
      setCurrentList(todo.item[index]);
    });
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo });
  };

  const onChange = (event, todo) => {
    const request = {
      name: todo.name,
      id: todo.id,
      completed: event.target.checked,
    };
    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
      });
  };

  const decorationDone = {
    textDecoration: "line-through",
  };
  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>ID</td>
            <td>Tarea</td>
            <td>¿Completado?</td>
          </tr>
        </thead>
        <tbody>
          {size(currentList) > 0 &&
            map(currentList, (todo, index) => {
              return (
                <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
                  <td>{todo.id}</td>
                  <td>{todo.name}</td>
                  <td>
                    <input
                      type="checkbox"
                      defaultChecked={todo.completed}
                      onChange={(event) => onChange(event, todo)}
                    ></input>
                  </td>
                  <td>
                    <button onClick={() => onDelete(todo.id)}>Eliminar</button>
                  </td>
                  <td>
                    <button onClick={() => onEdit(todo)}>Editar</button>
                  </td>
                </tr>
              );
            })}
        </tbody>
      </table>
    </div>
  );
};

export default ListTodo;
