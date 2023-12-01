import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Customer from "./Customer";
import Account from "./Account";

class App extends Component {

  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component ={Customer}/>
            <Route path='/account' exact={true} component ={Account}/>
          </Switch>
        </Router>
    )
  }
}
export default App;

