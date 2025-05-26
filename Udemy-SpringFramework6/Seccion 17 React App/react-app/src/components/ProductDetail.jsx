import { PropTypes } from "prop-types";

export const ProductDetail = ({
  product = {},
  handlerUpdate,
  handlerRemove,
}) => {
  return (
    <tr>
      <th>{product.id}</th>
      <th>{product.name}</th>
      <th>{product.price}</th>
      <th>{product.description}</th>
      <th>
        <button
          onClick={() => {
            handlerUpdate(product);
          }}
          className="btn btn-secondary btn-sm"
        >
          Update
        </button>
      </th>
      <th>
        <button
          onClick={() => {
            handlerRemove(product.id);
          }}
          className="btn btn-danger btn-sm"
        >
          Remove
        </button>
      </th>
    </tr>
  );
};

ProductDetail.propTypes = {
  product: PropTypes.object.isRequired,
  handlerRemove: PropTypes.func.isRequired,
  handlerUpdate: PropTypes.func.isRequired,
};
