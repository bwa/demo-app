import React, { Component } from 'react';
import { Table, Button } from 'reactstrap';
import { Test } from './service';
import Input from 'reactstrap/lib/Input';
//import {Test} from './service'

class App extends Component {

  state = {
    data: "Vent litt ..."
  }

  componentWillMount() {
    // initialiserer med et xhr kall for å sjekke at man har kontakt
    Test(this);
  }

  render() {
    let data = this.state.data;
    return (
    <div className="App container">
      <Table>
        <thead>
          <tr>
            <td>Ladekalkulator</td>
            <td></td>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Netto batterikapasitet (kWh format xx.xx)</td>
            <td><Input></Input></td>
          </tr>
          <tr>
            <td>Start ladeprosent (SoC)</td>
            <td><Input></Input></td>
          </tr>
          <tr>
            <td>Slutt ladeprosent (SoC)</td>
            <td><Input></Input></td>
          </tr>
          <tr>
            <td>Ladehastighet (kW format xx.xx)</td>
            <td><Input></Input></td>
          </tr>
          <tr>
            <td>Ladetid (tt:mm)</td>
            <td>{data}</td>
          </tr>
        </tbody>
      </Table>
      <Button color="success"> Kalkuler ladetid</Button>
    </div>
    )
  }
}


export default App;
