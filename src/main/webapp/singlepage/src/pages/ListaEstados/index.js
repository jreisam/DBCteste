import React from 'react';

class ListaEstados extends React.Component {
    constructor(props) {
        super(props);
        this.deleteEstado = this.deleteEstado.bind(this);

        console.log("no construtor: " + this.props);
    }

    deleteEstado() {
        this.props.deleteEstado(this.props.estados);
    }

    render() {
        return (

            <tr>
                <td>{this.props.nome}</td>
                <td>{this.props.codNome}</td>
                <td>{this.props.imgName}</td>
                {/*     <td>
                    <button className="btn btn-danger" onClick={this.deleteBcMsg}>Delete</button>
                </td>*/}
            </tr>
        );
    }
}
export  default ListaEstados;