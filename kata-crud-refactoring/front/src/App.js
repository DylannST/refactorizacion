import React, {
  useContext,
  useReducer,
  useEffect,
  useRef,
  useState,
  createContext,
} from "react";
import { StoreProvider} from "./components/Store";
import FormList from "./components/FormList"
import FormListTodos from "./components/FormListTodos"
function App() {

  return (
    <StoreProvider>
      <FormList />
      <FormListTodos/>
    </StoreProvider>
  );
}

export default App;
