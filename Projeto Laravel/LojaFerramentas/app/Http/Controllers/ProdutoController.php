<?php


namespace App\Http\Controllers;


use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Produto;


class ProdutoController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    //lista todos os produtos
    public function index()
    {
        $produtos = Produto::all();
        return view('produtos.index',compact('produtos'));


    }


    /**
     * Show the form for creating a new resource.
     */
    //abre o formulario de cadastro
    public function create()
    {
        return view('produtos.create');
    }


    /**
     * Store a newly created resource in storage.
     */
    // envia o formulario de cadastro
    public function store(Request $request)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'categoria'=> 'required',
            'quantidade'=> 'required|numeric',
            'preco'=> 'required|numeric',
        ]);


        Produto::create($request->all());


        return redirect()->route('produtos.index')->
        with('sucess','Produto Criado com Sucesso');
    }


    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Produto $produto)
    {
        return view('produtos.edit',compact('produto'));
    }


    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Produto $produto)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'categoria'=> 'required',
            'quantidade'=> 'required|numeric',
            'preco'=> 'required|numeric',
        ]);


        $produto->update($request->all());


        return redirect()->route('produtos.index')->
        with('sucess','Produto Atualizado com Sucesso');
    }


    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Produto $produto)
    {
        $produto->delete();


        return redirect()->route('produtos.index')->
        with('sucess','Produto Deletado com Sucesso');
    }
}
