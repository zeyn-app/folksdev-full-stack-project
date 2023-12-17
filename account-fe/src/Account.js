import React, {Component} from 'react';
import logo from "./logo.svg";
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import { Link } from 'react-router-dom';


class Account extends Component{

    constructor(props) {
        super(props);
        this.state = {
            createAccountRequest:{
                customerId: "",
                initialCredit: ""
            }
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event){
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.createAccountRequest};
        // createAccountRequest[name] = value;
        item[name] = value;
        this.setState({createAccountRequest: item});
    }

    async componentDidMount(){
        this.setState({
            createAccountRequest:{
                customerId: this.props.match.params.id,
                initialCredit: ""
            }
            }
        )
    }

    async handleSubmit(event) {
        event.preventDefault();
        const { createAccountRequest } = this.state;

        await fetch('/v1/accounts', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(createAccountRequest),
        });
        this.setState({
            createAccountRequest: {
                customerId: this.props.match.params.id,
                initialCredit: ""
            }
        });

        this.props.history.push('/');
    }

    render() {
        const {createAccountRequest} = this.state
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <div className="App-intro">
                        <h2>Create Account</h2>
                        <Form onSubmit={this.handleSubmit}>
                            <FormGroup>
                                <Label for="customerId">Name</Label>
                                <Input type="text" name="customerId" id="customerId" value={createAccountRequest.customerId || ''}
                                       disabled/>
                            </FormGroup>
                            <FormGroup>
                                <Label for="initialCredit">Initial Credit</Label>
                                <Input type="text" name="initialCredit" id="initialCredit" value={createAccountRequest.initialCredit || ''}
                                       onChange={this.handleChange} autoComplete="initialCredit"/>
                            </FormGroup>
                            <FormGroup>
                                <Button color="primary" type="submit" to={`/`} >Save</Button>{' '}
                                <Button color="secondary" tag={Link} to="/" >Cancel</Button>
                            </FormGroup>
                        </Form>
                        <div></div>
                    </div>
                </header>
            </div>
        );
    }



}

export default Account;