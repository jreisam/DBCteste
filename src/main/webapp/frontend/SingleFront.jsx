class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {selectedFile: ''};
        this.onFileChangeHandler = this.onFileChangeHandler.bind(this);
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
        fetch('https://dbcjreis-app.herokuapp.com/upload', {
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
                <div className="row">
                    <div className="col-md-6">
                        <div className="form-group files color">
                            <label>Upload arquvo XML </label>
                            <input type="file" className="form-control" name="file"
                                   onChange={this.onFileChangeHandler}/>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));