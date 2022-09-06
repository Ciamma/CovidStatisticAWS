//import logo from "./logo.svg";
import { Button, Col, Container, Row } from "react-bootstrap";
import { useState, useEffect } from "react";
import "./App.css";

function App() {
  const [sick, setSick] = useState(5);
  const [cure, setCure] = useState(10);

  useEffect(() => {
    // decommentali per vedere se funzionano i link
    // fetch("localhost:8765/getMalati")
    //   .then((response) => response.json())
    //   .then((data) => this.setSick(data));
    // fetch("localhost:8765/getGuariti")
    //   .then((response) => response.json())
    //   .then((data) => this.setSick(data));
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

  const button_injured = (
    <Button
      variant="danger"
      size="lg"
      style={{ marginRight: "20px" }}
      onClick={() => {
        setSick(sick + 1);
        // let request = {
        //   method: "POST",
        //   headers: { "Content-Type": "application/json" },
        //   body: JSON.stringify({ id: "00001" }),
        // };
        // fetch("localhost:8765/malato/", request);
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
        setCure(cure + 1);
        // let request = {
        //   method: "POST",
        //   headers: { "Content-Type": "application/json" },
        //   body: JSON.stringify({ id: "00001" }),
        // };
        // fetch("localhost:8765/guarito/", request);
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

  return (
    <div className="App">
      <Container>
        <header className="App-header">
          {title}
          {counters}
          {buttons}
        </header>
      </Container>
    </div>
  );
}

export default App;
