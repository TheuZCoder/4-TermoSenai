import Todo from '@/Models/ToDo';
import connectMongo from '@/utils/dbconnect';


export const getTodos = async () => {
  await connectMongo();
  return await Todo.find({});
};


export const createTodo = async (data) => {
  await connectMongo();
  return await Todo.create(data);
};


export const updateTodo = async (id, data) => {
  await connectMongo();
  return await Todo.findByIdAndUpdate(id, data, {
    new: true,
    runValidators: true,
  });
};


export const deleteTodo = async (id) => {
  await connectMongo();
  return await Todo.deleteOne({ _id: id });
};
