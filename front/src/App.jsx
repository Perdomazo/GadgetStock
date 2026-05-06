import { useState } from 'react'
import thragg from './assets/download.jpeg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

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
