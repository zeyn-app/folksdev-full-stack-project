import React, {Component} from 'react';

// /v1/accounts
class Account extends Component{
    state = {
        account: {
            transactions: []
        }
    };

    async handleSubmit(event) {
        event.preventDefault(); // butona basınca tüm sayfanın yenilenmesini engellliyor
        const {item} = this.state;

        await fetch('/v1/accounts', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/clients');
    }




}

export default Account;