import { useState } from 'react'
import { useEffect } from 'react'
import thragg from './assets/download.jpeg'
import './App.css'
import { useFetch } from './useFetch'

function App() {
  const [count, setCount] = useState(0)
  const { data } = useFetch('http://localhost:8080/gadget')

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
        </div>
        <ul>
          {data ? data.map((gadget) =>
             (<li key={gadget.id}>
                {gadget.name} - {gadget.model} - ${gadget.price.toFixed(2)} - 
                {gadget.comments} - 
              </li>))
               : <li>Loading...</li>}
        </ul>
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
