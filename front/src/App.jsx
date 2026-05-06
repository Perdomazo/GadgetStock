import { useState } from 'react'
import { useEffect } from 'react'
import thragg from './assets/download.jpeg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  const [gadgets, setGadgets] = useState([
  { id: 1, name: "iPhone 7", price: 1000, isSold: true, soldPrice: 800 },
  { id: 2, name: "Samsung S21", price: 3000, isSold: false, soldPrice: null }
]);

  useEffect(() => {

    });

  return (
    <>
      <section id="center">
        <div className="hero">
          <img src={thragg} className="base" width="170" height="179" alt="" />
        </div>
        <div>
          <h1>Gadget Stock</h1>
          <p>
            <code>Pronto el listado completo desde el BACKEND</code>
          </p>
          <ul>
            {gadgets.map((item)=>(
              <li key={item.id}>
                {item.name} - ${item.price} - {item.isSold} - ${item.soldPrice}
              </li>
            ))}
          </ul>
        </div>
        <button
          type="button"
          className="counter"
          onClick={() => setCount((count) => count + 1)}
        >
          Count is {count}
        </button>
      </section>

    </>
  )
}

export default App
