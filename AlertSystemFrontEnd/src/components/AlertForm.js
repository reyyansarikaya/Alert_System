import React, { Component } from 'react';
import './AlertForm.css';

import axios from 'axios'

class AlertForm extends Component {

   constructor(props) {
		super(props)

		this.state = {
			name: '',
			url: '',
			method: 'GET',
			periyod: '',

		}
	} 
    changeHandler = e => {
		this.setState({ [e.target.name]: e.target.value })
	}

	submitHandler = e => {
		e.preventDefault();
		axios.post('http://localhost:8080/alert  ', this.state)
			.then(response => {
				console.log(response)
			})

	}

  render() {
        const name = this.state.name ;
		const url = this.state.url ;
		const method = this.state.method ;
		const periyod = this.state.periyod ;


    return (

      <div className="Alert">

          <center>
      <form onSubmit={this.submitHandler}>
        <header className="Alert-header">


<table  >

      <tfoot>
        <tr>
        <td colSpan="2">&nbsp;</td>
        </tr>
        </tfoot>
        <tbody>
        <tr>
        <td>Name</td>
        <td><input className="input" type="text" placeholder="Please enter the name" onChange={this.changeHandler}
        name="name"
        value={name}
         /> </td>
        </tr>
        <tr>
        <td>URL</td>
        <td><input className="input"
        type="text"
        name="url"
        value={url} placeholder="Please enter the URL"
        onChange={this.changeHandler}/></td>
        </tr>
        <tr>
        <td>HTTP Method</td>

        <td><select  className="input" name="method" value={method} onChange={this.changeHandler}>
           <option  value="GET" >GET</option>
           <option  value="POST">POST</option>
        </select>
        </td>
        </tr>
        <tr>
        <td>Control Period</td>
        <td><input className="input"type="text"
        name="periyod"
        value={periyod}   placeholder="Please enter the period"
        onChange={this.changeHandler}  /></td>
        </tr>
         <tr>
         <td>&nbsp;</td>
          <td><button type="kaydet">Kaydet</button></td>
           </tr>
           </tbody>
            </table>

         </header> 
         </form>
          </center>
         </div>
    

    );


  }
}

export default AlertForm;