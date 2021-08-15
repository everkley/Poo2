import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Aluno } from './aluno.model';
import { AlunoService } from './aluno.service';

@Component({
  selector: 'app-aluno-novo',
  templateUrl: './aluno-novo.component.html',
  styleUrls: ['./aluno-novo.component.css']
})

export class AlunoNovoComponent implements OnInit {

  aluno: Aluno = new Aluno();

  constructor(
    private alunoService: AlunoService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  salvar() {
    this.alunoService.createAluno(this.aluno)
    .subscribe(
      dado => {
        console.log(dado)
        this.alunoService.openSnackBar('Aluno cadastrado com sucesso !');
        this.router.navigate(['/alunos']);
      }
    )
  }

  cancelar() {
this.router.navigate(['/alunos']);
  }



}
