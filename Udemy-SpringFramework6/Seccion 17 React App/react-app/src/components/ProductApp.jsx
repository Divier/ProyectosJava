import { useEffect, useState } from "react";
import { create, findAll, remove, update } from "../services/ProductService";
import { ProductGrid } from "./ProductGrid";
import { PropTypes } from "prop-types";
import { ProductForm } from "./ProductForm";

export const ProductApp = ({ title }) => {
  const [products, setProducts] = useState([]);

  const [productSelected, setProductSelected] = useState({
    id: "",
    name: "",
    description: "",
    price: "",
  });

  const getProducts = async() => {
    const result = await findAll();
    console.log(result);
    setProducts(result.data._embedded.products);
  }

  useEffect( () => {
    getProducts();
  }, []);

  const handlerAddFunction = async (product) => {
    console.log(products);
    console.log(product);

    if (product.id === "") {
      const response = await create(product);
      setProducts([
        ...products,
        { ...response.data },
      ]);
    } else {
      const response = await update(product);
      setProducts(
        products.map((prod) => {
          if (prod.id == response.data.id) {
            return { ...response.data };
          }
          return prod;
        })
      );
    }
  };

  const handlerUpdateFunction = (product) => {
    setProductSelected({ ...product });
  };

  const handlerRemoveFunction = (id) => {
    remove(id);
    setProducts(products.filter((product) => product.id != id));
  };

  return (
    <div className="container my-4">
      <h2>{title}</h2>
      <div className="row">
        <div className="col">
          <ProductForm
            handlerAdd={handlerAddFunction}
            productSelected={productSelected}
          />
        </div>
        <div className="col">
          {products.length > 0 ? (
            <ProductGrid
              products={products}
              handlerUpdate={handlerUpdateFunction}
              handlerRemove={handlerRemoveFunction}
            />
          ) : (
            <div className="alert alert-warning">
              No hay productos en el sistema!!!
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

ProductApp.propTypes = {
  title: PropTypes.string.isRequired,
};
