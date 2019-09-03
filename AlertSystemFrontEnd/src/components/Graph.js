import React from 'react'
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts'
import axios from 'axios'
import './Graph.css';

class Graph extends React.Component{

    state = {
        data2 : [],
        periyod : 0
    }

    componentDidMount() {
        setInterval(()=>
        {
            axios.get('http://localhost:8080/alert/' + this.props.match.params.name)
                .then((response) => {
                    console.log(response.data)
                    let results = response.data.result
                    let temp = []
                    results.forEach((result) => {
                        let date = result.resultDate
                        let situation = result.downOrUp
                        let now = {name: date, pv: situation, amt: 20000}
                        temp.push(now)
                    })
                    this.setState({data2: temp, periyod : response.data.periyod})
                    console.log(this.state.periyod)

                })
                .catch((error) => {
                    console.log(error.message)
                })
        },5000);
    }

    render() {
        return (
            <div className="Graph">
                <center>
                    <LineChart
                        width={500}
                        height={300}
                        data={this.state.data2}
                        margin={{
                            top: 5, right: 30, left: 20, bottom: 5,
                        }}
                    >
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="name" />
                        <YAxis />
                        <Tooltip />
                        <Legend />
                        <Line type="monotone" dataKey="pv" stroke="#14aa1a" activeDot={{ r: 8 }} />
                    </LineChart>
                 </center>
        </div>
        );
    }

}

export default Graph;