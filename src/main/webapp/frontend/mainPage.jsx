class App extends React.Component {
    constructor(props) {
        super(props);
        // this.deleteBcMsg = this.deleteBcMsg.bind(this);
        this.createBcMsg = this.createBcMsg.bind(this);
        this.state = {
            bcmsgs: [],
        };
    }

    componentDidMount() {
        this.loadBcMsgsFromServer();
    }

    // init
    loadBcMsgsFromServer() {
        fetch('https://dbcjreis-app.herokuapp.com/bcmsg')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    bcmsgs: responseData,
                });
            });
    }

/*    // Delete
    deleteBcMsg(bcmsg) {
        console.log(bcmsg);
        debugger;
        fetch(bcmsg,
            {method: 'DELETE',})
            .then(
                res => this.loadBcMsgsFromServer()
            )
            .catch(err => console.error(err))
    }*/

    // Create
    createBcMsg(bcmsg) {
        fetch('https://dbcjreis-app.herokuapp.com/bcmsg', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(bcmsg)
        })
            .then(
                res => this.loadBcMsgsFromServer()
            )
            .catch(err => console.error(err))
    }

    /* mainPage ----------- */
    render() {
        return (
            <div>
                <UploadFile createBcMsg={this.createBcMsg}/>
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
        if (this.props.bcmsgs != null) {
            var bcmsgs = this.props.bcmsgs.map(bcmsg =>

                <BcMsg key={bcmsg.self} bcmsg={bcmsg} deleteBcMsg={this.props.deleteBcMsg}/>
            );
        }

        return (
            <div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Dom Sist</th>
                        <th>Identd Emissor</th>
                        <th>Idendt Destinatário</th>
                        <th></th>
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

        console.log("no construtor: " + this.props);
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
           {/*     <td>
                    <button className="btn btn-danger" onClick={this.deleteBcMsg}>Delete</button>
                </td>*/}
            </tr>
        );
    }
}

class UploadFile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {domSist: '', identdEmissor: '', identdDestinatario: ''};
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.onFileChangeHandler = this.onFileChangeHandler.bind(this);
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
        var newBcMsg = {
            domSist: this.state.domSist,
            identdEmissor: this.state.identdEmissor,
            identdDestinatario: this.state.identdDestinatario
        };
        this.props.createBcMsg(newBcMsg);
    }

    onFileChangeHandler(event) {
        event.preventDefault();
        this.setState(
            {selectedFile: event.target.files[0]}
        );

        console.log(event.target.files[0]);
        const formData = new FormData();
        formData.append('file', event.target.files[0]);
        fetch('https://dbcjreis-app.herokuapp.com/upload', {
            method: 'post',
            body: formData
        }).then(res => {
            if (res.ok) {
                // alert("feito.")
                window.location.reload();
            }
        });
    };

    render() {
        return (
            <div className="container">
                <div className="row"></div>
                <div className="row"></div>
                <div className="card">
                    <div className="card-body">
                        <h5 className="card-title"> Upload do arquivo XML </h5>
                        <div className="form-group files color">
                            <label></label>
                            <input type="file" className="form-control" name="file"
                                   onChange={this.onFileChangeHandler}/>
                        </div>
                        <p/>
                    </div>
                </div>

                <div className="panel panel-default">
                   {/* <div className="panel-heading">Arquivo XML</div>
                    <div className="panel-body">
                        <form className="form-inline">
                            <div className="col-md-2">
                                <input type="text" placeholder="Sist" className="form-control" name="domSist"
                                       onChange={this.handleChange}/>
                            </div>
                            <div className="col-md-2">
                                <input type="text" placeholder="Idendt Emissor" className="form-control"
                                       name="identdEmissor" onChange={this.handleChange}/>
                            </div>
                            <div className="col-md-2">
                                <input type="text" placeholder="Idendt Destinatário" className="form-control"
                                       name="identdDestinatario" onChange={this.handleChange}/>
                            </div>
                            <div className="col-md-2">
                                <button className="btn btn-success" onClick={this.handleSubmit}>Salvar teste</button>
                            </div>
                        </form>
                    </div>*/}
                </div>

            </div>


        );
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));