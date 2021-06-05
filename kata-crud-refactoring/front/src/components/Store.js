import React, { createContext, useReducer } from "react";

const initialState = {
  list: {
    todoLists: [],
  },
  todo: {
    component: [],
    item: [],
  },
};
const Store = createContext(initialState);

export function reducer(state,action) {
  switch (action.type) {
    case "update-item":
      const todoUpItem = state.todo;
      const listUpdateEdit = todoUpItem.item.map((item) => {
        if (item.id === action.item.id) {
          return action.item;
        }
        return item;
      });
      todoUpItem.component = listUpdateEdit;
      todoUpItem.item = {};
      return { ...state, todo: todoUpItem };
    case "delete-item":
      console.log(action)
      const todoUpDelete = state.todo;
      const listUpdate = todoUpDelete.item.filter((item) => {
        return item.id !== action.id;
      });
      todoUpDelete.item = listUpdate;
      return { ...state, todo: todoUpDelete };
    case "add-list":
      const todoUpList = state.todo;
      todoUpList.list = action.list;
      return { ...state, todo: todoUpList };
    case "edit-item":
      const todoUpEdit = state.todo;
      todoUpEdit.item = action.item;
      return { ...state, todo: todoUpEdit };
    case "add-item":
      const todoUp = state.todo.component;
      const todoItem = state.todo.item;
      todoUp.push(action.item);
      todoItem.push(action.item)
      
      return { ...state, todo: { component: todoUp, item: todoItem} };
    case "add-item-group":
      const listsUP = state.list.todoLists;
      listsUP.push(action.todoLists);
      return { ...state, list: { todoLists: listsUP } };
    case "delete-item-group":
      const listsUPDelete = state.list.todoLists.filter((list) => {
        return list.id !== action.idDelete;
      });
      return { ...state, list: { todoLists: listsUPDelete } };
    case "post-list-group":
      return { ...state, list: { todoLists: action.todoLists } };
      case "get-todos-by-id":
        const listTodos = state.todo.item;
        listTodos.push(action.listTodo);
        return { ...state, todo: { component: [], item: listTodos } };
      default:
      return state;
  }
}

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};

export default Store;
