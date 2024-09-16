import mongoose from "mongoose";

const database = process.env.DATABASE_URL;

if (!database) {
    console.error("Adicione o caminho da Database no ENV");
    process.exit(1);
}

const dbConnect = async () => {
    try {
        const conn = await mongoose.connect(database, {
            useUnifiedTopology: true,
            useNewUrlParser: true,
            useCreateIndex: true,
        });
        console.log(`MongoDB Connected: ${conn.connection.host}`);
    } catch (error) {
        console.error(`Error: ${error.message}`);
        process.exit(1);
    }
};

export default dbConnect;