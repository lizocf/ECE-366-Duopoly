import React from 'react'
import { useState, useEffect} from "react";
import axios from "axios";
import "../style.css";


const UpdateDirection = () => {
    function UpdateLeft() {
        var left_button = document.getElementById("left");
        var right_button = document.getElementById("right");
        axios.post("http://localhost:8080/updateDir", {
            user_id : "1",
            game_id : "1",
            direction : "left"
        })
        left_button.style.display='none';
        right_button.style.display='none';
    }
    
    function UpdateRight() {
        var left_button = document.getElementById("left");
        var right_button = document.getElementById("right");
        axios.post("http://localhost:8080/updateDir", {
            user_id : "1",
            game_id : "1",
            direction : "right"
        })
        left_button.style.display='none';
        right_button.style.display='none';
    }
    
    return (
      <>
        <div className="center" style={{margin: "5vh auto"}}>
            <div className="arrow" id="left"
                 onClick={() => UpdateLeft()}></div>
            <div className="arrow" id="right" 
                 onClick={() => UpdateRight()} 
                 style={{transform: "rotate(180deg)"}}></div>
        </div>
        <script>
        </script>
    </>
    )
  }


  export default UpdateDirection