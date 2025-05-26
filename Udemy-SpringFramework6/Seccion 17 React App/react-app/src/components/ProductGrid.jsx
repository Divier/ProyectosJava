import { ProductDetail } from "./ProductDetail";
import { PropTypes } from "prop-types";

export const ProductGrid = ({
  products = [],
  handlerUpdate,
  handlerRemove,
}) => {
  return (
    <table className="table table-hover table-striped">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Price</th>
          <th>Description</th>
          <th>Update</th>
          <th>Remove</th>
        </tr>
      </thead>
      <tbody>
        {products.map((product) => {
          return (
            <ProductDetail
              product={product}
              key={product.id}
              handlerUpdate={handlerUpdate}
              handlerRemove={handlerRemove}
            />
          );
        })}
      </tbody>
    </table>
  );
};

ProductGrid.propTypes = {
  products: PropTypes.array.isRequired,
  handlerRemove: PropTypes.func.isRequired,
  handlerUpdate: PropTypes.func.isRequired,
};
