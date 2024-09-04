import mongoose from "mongoose";


const TodoSchema = new mongoose.Schema({
    title:{
        type:String,
        required:true
    },
    description:{
        type:String,
        required:false
    },
    completed:{
        type:String,
        enum:['A Fazer', 'Fazendo','Concluído'],
        default:'A Fazer'
    }
});


const Todo = mongoose.models.Todo || mongoose.model('Todo',TodoSchema);


export default Todo;
