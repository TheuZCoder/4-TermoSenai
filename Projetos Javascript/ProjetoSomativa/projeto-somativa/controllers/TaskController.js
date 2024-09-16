import Task from "@/models/Task";
import connectMongo from "@/utils/dbConnect";


//CRUD
export const getTask = async (userId) => {
    await connectMongo();
    return await Task.find(userId);
}


export const createTask = async (data) => {
    await connectMongo();
    return await Task.create(data);
}


export const updateTask = async (id, data) => {
    await connectMongo();
    return await Task.findByIdAndUpdate(id, data, {
        new: true,
        runValidators: true
    })
}


export const deleteTask = async (id) => {
    await connectMongo();
    return await Task.deleteOne({_id:id});
}
