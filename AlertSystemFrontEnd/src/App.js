import React from 'react';
import './App.css';
import  AlertForm from './components/AlertForm'
import AlertList from './components/AlertList'
import Graph from './components/Graph'

import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';

function App() {
  return (   <div className="App">
        <Router>

        <div className="topnav">
        <a className="active" href="/">Home</a>
        <a href="/alert/">List</a>
        < p className="p"> Alert System</p>
        </div>
        <div>
        <head>
        <p>Alert System</p>
        </head>
        </div>

        <Switch>
            <Route className="Graph" path="/alert/:name" component = {Graph}/>
            <Route className="AlertList"path = '/alert' component = {AlertList}/>
            <Route className="AlertForm" path = "/" component = {AlertForm}/>
        </Switch>

        </Router>



    </div>




);
}

export default App;