import axios from "axios";

const initProducts = [
    {
        id: Math.floor(Math.random() * 1000),
        name: "Producto 1",
        price: 100,
        description: "Descripcion producto 1"
    },
    {
        id: Math.floor(Math.random() * 1000),
        name: "Producto 2",
        price: 200,
        description: "Descripcion producto 2"
    }
];

const baseURL = 'http://localhost:8080/products';

export const listProducts = () => {
    return initProducts;
}

export const findAll = async () => {

    try {
        const response = await axios.get(baseURL);
        return response;
    } catch (error) {
        console.log(error);
    }
}

export const create = async ({ name, description, price }) => {

    try {
        const response = await axios.post(baseURL, { name, description, price });
        return response;
    } catch (error) {
        console.log(error);
    }
}

export const update = async ({ id, name, description, price }) => {

    try {
        const response = await axios.put(`${baseURL}/${id}`, { name, description, price });
        return response;
    } catch (error) {
        console.log(error);
    }
}

export const remove = async(id) => {
   
    try {
        await axios.delete(`${baseURL}/${id}`);
    } catch (error) {
        console.log(error);
    }
}