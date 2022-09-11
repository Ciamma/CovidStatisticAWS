import React from 'react'
//import ReactDOM from 'react-dom'
//import logo from "./logo.svg";
import { Button, Col, Container, Row } from "react-bootstrap";
import { useState, useEffect } from "react";
import "./App.css";

function App() {
  const [sick, setSick] = useState(5);
  const [cure, setCure] = useState(10);
  const [id, setId] = useState("");

  useEffect(() => {
    fetch(
      "http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/nMalati"
    )
      .then((response) => response.json())
      .then((data) => setSick(data));
    fetch(
      "http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/nGuariti"
    )
      .then((response) => response.json())
      .then((data) => setCure(data));
  });

  const title = (
    <Row>
      <h1>Welcome to Covid counters!</h1>
    </Row>
  );

  const counter_positives = (
    <Col style={{ marginRight: "50px" }}>
      <h1>{sick}</h1>
      <h2>Malati</h2>
    </Col>
  );

  function refreshPage() {
    window.location.reload(false);
  }

  const counter_negatives = (
    <Col style={{ marginLeft: "50px" }}>
      <h1>{cure}</h1>
      <h2>Guariti</h2>
    </Col>
  );

  const counters = (
    <div className="rowC">
      {counter_positives}
      {counter_negatives}
    </div>
  );

  function idRandom() {
    if (id !== "") {
      return id;
    }
    var result = "";
    var characters =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (var i = 0; i < 10; i++) {
      result += characters.charAt(
        Math.floor(Math.random() * characters.length)
      );
    }
    setId(result);
  }

  const button_injured = (
    <Button
      variant="danger"
      size="lg"
      style={{ marginRight: "20px" }}
      onClick={async () => {
        idRandom();
        let request = {
          method: "POST",
        };
        await fetch(
          "http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/malato/" +
            id,
          request
        ).then(refreshPage());
      }}
    >
      Sono positivo
    </Button>
  );

  const button_healed = (
    <Button
      variant="success"
      size="lg"
      style={{ marginLeft: "20px" }}
      onClick={() => {
        idRandom();
        let request = {
          method: "POST",
        };
        fetch(
          "http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/guarito/" +
            id,
          request
        );
        refreshPage();
      }}
    >
      Sono guarito
    </Button>
  );

  const buttons = (
    <Row>
      {button_injured}
      {button_healed}
    </Row>
  );

  const past_days = (
    <Row>
      <table>
        <tbody>
          <tr>
            <td>13/09/2023</td>
            <td>24</td>
            <td>36</td>
          </tr>
        </tbody>
      </table>
    </Row>
  );

  return (
    <div className="App">
      <Container>
        <header className="App-header">
          {title}
          {counters}
          {buttons}
          Giorni passati
          {past_days}
        </header>
      </Container>
    </div>
  );
}

export default App;
