import { useEffect, useState } from "react";
import { PropTypes } from "prop-types";

const initDataForm = {
  id: "",
  name: "",
  description: "",
  price: "",
};

export const ProductForm = ({ handlerAdd, productSelected }) => {
  const [form, setForm] = useState(initDataForm);

  const { id, name, description, price } = form;

  useEffect(() => {
    setForm(productSelected);
  }, [productSelected]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!name || !description || !price) {
          return;
        }
        handlerAdd(form);
        setForm(initDataForm);
      }}
    >
      <div>
        <input
          placeholder="Name"
          name="name"
          value={name}
          onChange={(event) => {
            setForm({
              ...form,
              name: event.target.value,
            });
          }}
          className="form-control my-3 w-75"
        />
      </div>
      <div>
        <input
          placeholder="Description"
          name="description"
          value={description}
          onChange={(event) => {
            setForm({
              ...form,
              description: event.target.value,
            });
          }}
          className="form-control my-3 w-75"
        />
      </div>
      <div>
        <input
          placeholder="Price"
          name="price"
          value={price}
          onChange={(event) => {
            setForm({
              ...form,
              price: event.target.value,
            });
          }}
          className="form-control my-3 w-75"
        />
      </div>
      <button type="submit" className="btn btn-primary">
        {id === "" ? "Create" : "Update"}
      </button>
    </form>
  );
};

ProductForm.propTypes = {
  handlerAdd: PropTypes.func.isRequired,
  productSelected: PropTypes.object.isRequired,
};
