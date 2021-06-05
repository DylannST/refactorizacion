import React, { createContext, useReducer } from "react";

const initialState = {
  list: {
    todoLists: [],
  },
  todo: {
    component: [],
    item: {},
  },
};
const Store = createContext(initialState);

export function reducer(state,action) {
  switch (action.type) {
    case "update-item":
      const todoUpItem = state.todo;
      const listUpdateEdit = todoUpItem.list.map((item) => {
        if (item.id === action.listComplete.id) {
          return action.listComplete;
        }
        return item;
      });
      todoUpItem.list = listUpdateEdit;
      todoUpItem.item = {};
      return { ...state, todo: todoUpItem };
    case "delete-item":
      const todoUpDelete = state.todo;
      const listUpdate = todoUpDelete.list.filter((item) => {
        return item.id !== action.id;
      });
      todoUpDelete.list = listUpdate;
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
      const todoUp = state.todo.list;
      todoUp.push(action.item);
      return { ...state, todo: { list: todoUp, item: {} } };
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
