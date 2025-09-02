// transactions.component.ts
import { Component, OnInit } from '@angular/core';
import { TransactionService } from './transaction.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [CommonModule],
  template: `
    <ul>
      <li *ngFor="let tx of transactions">
        {{ tx.fromAccount }} → {{ tx.toAccount }} : {{ tx.amount }}€
      </li>
    </ul>
  `
})
export class TransactionsComponent implements OnInit {
  transactions: any[] = [];
  constructor(private txService: TransactionService) {}

  ngOnInit() {
    this.txService.getTransactions().subscribe(data => this.transactions = data);
    this.txService.onTransaction(tx => this.transactions.unshift(tx));
  }
}
