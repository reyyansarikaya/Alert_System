import React, {Component} from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";
import './AlertList.css';

class AlertList extends Component {

    state = {
        alerts: []
    };

    componentDidMount(){
        console.log("data component mounted");
        this.retrieveData();
    }

    retrieveData=()=>{
        console.log("data retrieveData mounted");
        console.log("data retrieveData mounted");

        axios.get('http://localhost:8080/alert')
            .then(res => {
                const alerts = res.data;
                this.setState({ alerts });
            })
    }

    render() {
        let myTableData = this.state.alerts.map((element , elIndex) => {
            return <tr  key={elIndex}>
                <td>{element.name}</td>
                <td>{element.url}</td>
                <td>{element.method}</td>
                <td>{element.periyod}</td>

                <td>
                <h1>
                <button className="button" >  <Link to={{pathname: '/alert/'+element.name}}  >{element.name}</Link> </button>
                </h1>
                </td>
            </tr>;
        });

        let myTable = <table className="Table">
                <thead bgcolor="#4CB050">
                <tr>
                <th>Name</th>
                <th>Url</th>
                <th>Method</th>
                <th>Periyod</th>
                <th>Graph</th>
                </tr>
                </thead>
                <tbody border="1" bgcolor="#333333">
                {myTableData}
                </tbody>
                </table>;

        return <div border="1">
            <center>
            {myTable}
            </center>
            </div>;
    }

}

export default AlertList;