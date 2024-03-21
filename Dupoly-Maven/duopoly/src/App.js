import "./App.css";
import {Component } from "react";
import PlayerTable from "./components/playertable";


// function App() {
//     const [data, setData] = useState([]);
//     const loadUsers = async () => {
//           const response = await axios.get(`http://localhost:8080/getAllPlayersInGame/1`);
//           setData(response.data)
//         }
//         useEffect(() => {
//             loadUsers();
//     }, []);
//     if (data)
//         return (
//             <pre>{JSON.stringify(data, null, 2)}</pre>
//         );
//     return <h1>Data</h1>;
// }

class App extends Component {
    render() {
        return (
            <>
                <PlayerTable />
            </>
        )
    }
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