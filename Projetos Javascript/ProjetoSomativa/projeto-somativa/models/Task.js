import mongoose from "mongoose";

const TaskSchema = new mongoose.Schema({
    userId: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
        required: true
    },
    title: {
        type: String,
        required: true
    },
    status: {
        type: String,
        enum: ['Concluída', 'Pendente', 'Parado'],
        default: 'Pendente'
    }
});

const Task = mongoose.models.Task || mongoose.model('Task', TaskSchema);

export default Task;
