class App extends React.Component {
    constructor(props) {
        super(props);
        this.deleteBcMsg = this.deleteBcMsg.bind(this);
        this.createBcMsg = this.createBcMsg.bind(this);
        this.state = {
            bcmsgs: [],
        };
    }

    componentDidMount() {
        this.loadBcMsgsFromServer();
    }

    // Load students from database
    loadBcMsgsFromServer() {
        fetch('http://localhost:8080/bcmsg')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    bcmsgs: responseData,
                });
            });
    }

    // Delete student
    deleteBcMsg(bcmsg) {
console.log(bcmsg);
debugger;
// TODO: implementar DELETE no rest backend ; e incluir aqui o UploadFile do SingleFront
        fetch (bcmsg,
            { method: 'DELETE',})
            .then(
                res => this.loadBcMsgsFromServer()
            )
            .catch( err => console.error(err))
    }

    // Create new student
    createBcMsg(bcmsg) {
        fetch('http://localhost:8080/bcmsg', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(bcmsg)
        })
            .then(
                res => this.loadBcMsgsFromServer()
            )
            .catch( err => console.error(err))
    }

    render() {
        return (
            <div>
                <BcMsgForm createBcMsg={this.createBcMsg}/>
                <BcMsgTable deleteBcMsg={this.deleteBcMsg} bcmsgs={this.state.bcmsgs}/>
            </div>
        );
    }
}

class BcMsgTable extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        if(this.props.bcmsgs != null) {
            var bcmsgs = this.props.bcmsgs.map(bcmsg =>

                <BcMsg key={bcmsg.self} bcmsg={bcmsg} deleteBcMsg={this.props.deleteBcMsg}/>
            );
        }

        return (
            <div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Dom Sist</th><th>Identd Emissor</th><th>Idendt Destinatário</th><th> </th>
                    </tr>
                    </thead>
                    <tbody>{bcmsgs}</tbody>
                </table>
            </div>);
    }
}

class BcMsg extends React.Component {
    constructor(props) {
        super(props);
        this.deleteBcMsg = this.deleteBcMsg.bind(this);

        console.log("no construtor" + this.props);
    }

    deleteBcMsg() {
        this.props.deleteBcMsg(this.props.bcmsg);
    }

    render() {
        return (

            <tr>
                <td>{this.props.bcmsg.domSist}</td>
                <td>{this.props.bcmsg.identdEmissor}</td>
                <td>{this.props.bcmsg.identdDestinatario}</td>
                <td>
                    <button className="btn btn-danger" onClick={this.deleteBcMsg}>Delete</button>
                </td>
            </tr>
        );
    }
}

class BcMsgForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {domSist: '', identdEmissor: '', identdDestinatario: ''};
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        console.log("NAME: " + event.target.name + " VALUE: " + event.target.value)
        this.setState(
            {[event.target.name]: event.target.value}
        );
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log("Submit: " + this.state.domSist);
        var newBcMsg = {domSist: this.state.domSist, identdEmissor: this.state.identdEmissor, identdDestinatario: this.state.identdDestinatario};
        this.props.createBcMsg(newBcMsg);
    }

    render() {
        return (
            <div className="panel panel-default">
                <div className="panel-heading">Arquivo XML</div>
                <div className="panel-body">
                    <form className="form-inline">
                        <div className="col-md-2">
                            <input type="text" placeholder="Sist" className="form-control"  name="domSist" onChange={this.handleChange}/>
                        </div>
                        <div className="col-md-2">
                            <input type="text" placeholder="Idendt Emissor" className="form-control" name="identdEmissor" onChange={this.handleChange}/>
                        </div>
                        <div className="col-md-2">
                            <input type="text" placeholder="Idendt Destinatário" className="form-control" name="identdDestinatario" onChange={this.handleChange}/>
                        </div>
                        <div className="col-md-2">
                            <button className="btn btn-success" onClick={this.handleSubmit}>Salvar</button>
                        </div>
                    </form>
                </div>
            </div>

        );
    }
}

ReactDOM.render(<App />, document.getElementById('root') );