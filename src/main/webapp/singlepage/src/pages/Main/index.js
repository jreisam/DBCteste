import React from 'react';
import bandeiraPN from '../../images/bandeiraPN.PNG';
import bandeiraRS from '../../images/bandeiraRS.PNG';
import bandeiraSC from '../../images/bandeiraSC.PNG';
import ListaEstados from '../ListaEstados/index';

class Main extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            uf: 'santacatarina',
            estados: [],
            bandeiras: [
                {
                    id: 1,
                    img: bandeiraRS
                },
                {
                    id: 2,
                    img: bandeiraSC
                },
                {
                    id: 3,
                    img: bandeiraPN
                }
            ],
            bandeirasSelected: 2
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        this.loadEstadosFromServer();
    }

    loadEstadosFromServer() {
        fetch('http://localhost:8080/estado')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    estados: responseData,
                });
            });
    }

    handleChange(event) {
        this.setState({uf: event.target.value,
            bandeirasSelected:  event.target.options.selectedIndex
        });

    }

    handleSubmit(event) {
        alert('selecionado: ' + this.state.uf);
        event.preventDefault();
    }

    render() {
        console.log(this.state.estados);
debugger;
        if (this.state.estados != null) {
            var estados = this.state.estados.map(estado =>

                <ListaEstados key={estado.id} nome={estado.nome} codNome={estado.codNome} imgName={estado.imgName}/>
            );
        }

        return (
            <div className="row">
                <div className="logo">

                    <img src={this.state.bandeiras[this.state.bandeirasSelected]["img"]} width="100" height="50" />
                </div>

            <form onSubmit={this.handleSubmit}>
                <label>
                    Estado:
                    <select value={this.state.uf} onChange={this.handleChange}>
                        <option value="riograndedosul">Rio Grande do Sul</option>
                        <option value="santacatarina">Santa Catarina</option>
                        <option value="parana">Paraná</option>
                    </select>
                </label>
                <input type="submit" value="Enviar" />
            </form>


                 <table className="table table-striped">
                        <thead>
                        <tr>
                            <th>Nome</th>
                            <th>CodNome</th>
                            <th>ImgName</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>{estados}</tbody>
                    </table>
            </div>

        );
    }
}

export  default Main;