import Register from './register/page';
import Login from './login/page';
import TodoList from './api/auth/tasks/page';

export default function Home() {
  return (
    <div>
      <h1>To-Do List App</h1>
      <Register />
      <Login />
      <TodoList />
    </div>
  );
}