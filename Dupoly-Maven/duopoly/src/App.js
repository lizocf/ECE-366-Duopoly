import "./App.css";
import { useState, useEffect } from "react";
import axios from "axios";

function App() {
    const [data, setData] = useState([]);
    const loadUsers = async () => {
          const response = await axios.get(`http://localhost:8080/getAllPlayersInGame/1`);
          setData(response.data)
        }
        useEffect(() => {
            loadUsers();
    }, []);
    if (data)
        return (
            <pre>{JSON.stringify(data, null, 2)}</pre>
        );
    return <h1>Data</h1>;
}

export default App;

// function Home() {
//   const [data, setData] = useState(null);
//   useEffect(() => {

//       const loadUsers = async () => {
//           const response = await axios.get(`http://localhost:8080/getAllPlayersInGame/1`);
//           setData(response.data)
//       }
//       loadUsers();
//   }, []);
//   if (data)
//       return (
//           <>
//               <h1>RPS</h1>
//               <nav>
//                   <Link to="/about">About</Link>
//                   <Link to="/contact">Contact</Link>
//               </nav>
//               <pre>{JSON.stringify(data, null, 2)}</pre>
//           </>
//       );
//   return <h1>Data</h1>;
// }