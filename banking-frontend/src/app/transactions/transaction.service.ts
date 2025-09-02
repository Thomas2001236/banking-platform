// transaction.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { io, Socket } from 'socket.io-client';

@Injectable({ providedIn: 'root' })
export class TransactionService {
  private apiUrl = 'http://localhost:8081/api/transactions';
  private socket: Socket;

  constructor(private http: HttpClient) {
    this.socket = io('http://localhost:8083/ws');
  }

  getTransactions(): Observable<any[]> { return this.http.get<any[]>(this.apiUrl); }

  onTransaction(callback: (tx: any) => void) {
    this.socket.on('transactions', callback);
  }
}
