import { size } from "lodash";
import React, {
  useContext,

  useEffect,
  useState
} from "react";
import "./formListTodos.css";
import FormTodo from "./FormTodo";
import ListTodo from "./ListTodo";
import Store from "./Store";




const FormListTodos = () => {
  const { state: { list, todo }, dispatch } = useContext(Store);
  const HOST_API = "http://localhost:8080/api";

  const decorationDone = {
    textDecoration: "line-through",
  };

  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/ListTodos", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-item-group", idDelete: id });
    });
  };

  useEffect(() => {
    fetch(HOST_API + "/ListTodos")
      .then(response => response.json())
      .then((list) => {
          dispatch({ type: "post-list-group", todoLists: list})
        
      })
  }, [dispatch]);

  const [change, setChange] = useState(false)
// <ListTodo list={valor}/>
  return (
    <div>
      {list.todoLists.map((valor, index) => (
         <div key={valor.id} className="divBorder">
         <p>{valor.name}</p>
         <button onClick={() => onDelete(valor.id)}>Eliminar</button>
         <div>  
         </div>
        <FormTodo list={valor} index={index} setChange={setChange} change={change}/>
        <ListTodo idListTodo={valor.id} index={index} change={change} sizes={size(list.todoLists)}/>
       
       </div>         
      ))}
    </div>
  );
};
export default FormListTodos;
