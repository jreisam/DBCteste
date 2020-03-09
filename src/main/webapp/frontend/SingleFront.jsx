
class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {selectedFile: ''};
        this.onFileChangeHandler = this.onFileChangeHandler.bind(this);

        this.state = {
            doc: []
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/bcmsg')
            .then(res => res.json())
            .then((data) => {
                this.setState({doc: data})
            })
            .catch(console.log)
    }


    onFileChangeHandler(event) {
        event.preventDefault();
        this.setState(
            {selectedFile: event.target.files[0]}
        );

        console.log(event.target.files[0]);
        // this.setState({
        //     selectedFile: event.target.files[0]
        // });
        const formData = new FormData();
        formData.append('file', event.target.files[0]);
        fetch('http://localhost:8080/upload', {
            method: 'post',
            body: formData
        }).then(res => {
            if (res.ok) {
                alert("feito.")
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
                            <label>Upload arquvo XML </label>
                            <input type="file" className="form-control" name="file"
                                   onChange={this.onFileChangeHandler}/>
                        </div>
                        <p/>
                    </div>
                </div>

                <Doc doc={this.state.docs} />

            </div>


        )
    }
}


class docTable extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        var docs = this.props.docs.map(doc =>
            <Student key={student._links.self.href} student={student} deleteStudent={this.props.deleteStudent}/>
        );

        return (
            <div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Firstname</th><th>Lastname</th><th>Email</th><th> </th>
                    </tr>
                    </thead>
                    <tbody>{students}</tbody>
                </table>
            </div>);
    }
}

class Doc extends React.Component {
    constructor(props) {
        super(props);
    }

/*
{
    "id": 2,
    "domSist": "SPB01",
    "identdDestinatario": "99999999",
    "identdEmissor": "12345678",
    "grupoSeqs": {
        "id": 3,
        "numSeq": "1",
        "indrCont": "N"
    },
    "nuop": "12345678912345678912345"
}*/
    render() {
        return (
            <div style="text-align: center;">
                <h1>Documento XML</h1>
                {doc.map((doc) => (
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">{doc.domSist}</h5>
                            <h6 className="card-subtitle mb-2 text-muted">{doc.identdDestinatario}</h6>
                            <p className="card-text">{doc.grupoSeqs.id}</p>
                        </div>
                    </div>
                ))}
            </div>
        );
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));