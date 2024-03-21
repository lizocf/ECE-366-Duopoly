import React from 'react'
import { useState, useEffect} from "react";
import axios from "axios";
import "../style.css";

const PlayerTable = () => {
    const [players, setPlayers] = useState([]);
    useEffect(() => {
        const loadPlayers = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/getAllPlayersInGame/1`);
                setPlayers(response.data.filter(player => player !== null).map(player => ({ userId: player.userId, cash: player.cash })));
            } catch (error) {
                console.error('Error fetching players:', error);
            }
        };
        loadPlayers();
    }, []);

    return (
      <>
        <main className="table" id="Players">
            <section className="table__body">
            <h1>Players</h1>
                <table>
                    <thead>
                        <tr>
                            <th> id </th>
                            <th> cash </th>
                        </tr>
                    </thead>
                    <tbody>
                        {players.map((player, index) => (
                            <tr key={index}>
                            <td>{player.userId}</td>
                            <td>{player.cash}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </section>
        </main>
    </>
    )
  }


  export default PlayerTable