import mongoose from "mongoose";

const taskSchema = new mongoose.Schema({
    userId: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "User",
        required: [true, "Please provide a user id"],
    },
    name: {
        type: String,
        required: [true, "Please provide a name"],
    },
    completed: {
        type: Boolean,
        default: false,
    },
});

const task = mongoose.models.Task || mongoose.model("Task", taskSchema);

export default task;