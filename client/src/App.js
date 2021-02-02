import React, { Component } from 'react';
import { Table, Button } from 'reactstrap';
import { Test } from './service';
import Input from 'reactstrap/lib/Input';

class App extends Component {

  state = {
    data: "Vent litt. Henter data fra server ...."
  }

  componentWillMount() {
    // initialiserer med et xhr kall for å sjekke at man har kontakt
    Test(this);
  }

  render() {
    let data = this.state.data;
    return (
    <div className="App container">
        <div>Hello world</div>
        <div><hr/></div>
        <div>{data}</div>
    </div>
    )
  }
}


export default App;
