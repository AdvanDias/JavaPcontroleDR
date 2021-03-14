# JavaPcontroleDR

<h1>Projeto Java Controle de Receita e Dispesa</h1>

<h2>Padrão utilizado no projeto JAVA: </h2>
1 - MVC <br>
2 -  JFrame Form

<h2>Procedimentos utilizado no banco de dados Oracle: </h2>

<h3>PL/SQL: Responsável por gerar um arquivo txt. da tabela log preenchida. </h3>

<h4>Código: </h4>
DECLARE<br>
 arquivo_saida UTL_File.File_Type;<br>
 Cursor Cur_Linha is<br>
 SELECT USUARIO, HORARIO, VALOR_ANTIGO, VALOR_NOVO FROM LOG; <br>
BEGIN<br>
 arquivo_saida := UTL_File.Fopen('DIRETORIO','Lista.txt','w');<br>
 For Reg_Linha in Cur_linha Loop<br>
 UTL_File.Put_Line(arquivo_saida, Reg_linha.USUARIO||';'||Reg_linha.HORARIO||';'||Reg_linha.VALOR_ANTIGO||';'||Reg_linha.VALOR_NOVO);<br>
 End Loop;<br>
 UTL_File.Fclose(arquivo_saida);<br>
 Dbms_Output.Put_Line('Arquivo gerado com sucesso.');<br>
EXCEPTION<br>
 WHEN UTL_FILE.INVALID_OPERATION THEN<br>
 Dbms_Output.Put_Line('Operação inválida no arquivo.');<br>
 UTL_File.Fclose(arquivo_saida);<br>
 WHEN UTL_FILE.WRITE_ERROR THEN<br>
 Dbms_Output.Put_Line('Erro de gravação no arquivo.');<br>
 UTL_File.Fclose(arquivo_saida);<br>
 WHEN UTL_FILE.INVALID_PATH THEN<br>
 Dbms_Output.Put_Line('Diretório inválido.');<br>
 UTL_File.Fclose(arquivo_saida);<br>
 WHEN UTL_FILE.INVALID_MODE THEN<br>
 Dbms_Output.Put_Line('Modo de acesso inválido.');<br>
 UTL_File.Fclose(arquivo_saida);<br>
 WHEN Others THEN<br>
 Dbms_Output.Put_Line('Problemas na geração do arquivo.');<br>
 UTL_File.Fclose(arquivo_saida);<br>
END;<br>

<h3>Trigger's:</h3>
<h4>1 -  GERA_LOG_ALT</h4>
<h5> Funcionalidade: Monitora alteração feita no campo class da tabela cliente.</h5>

<h5> Código: </h5>
create or replace TRIGGER GERA_LOG_ALT<br>
AFTER UPDATE OF CLASSE ON CLIENTE FOR EACH ROW<br>
DECLARE<br>
BEGIN<br>
       INSERT INTO LOG (USUARIO,HORARIO,VALOR_ANTIGO, VALOR_NOVO)<br>
        VALUES (USER,SYSDATE,:OLD.CLASSE, :NEW.CLASSE);<br>
END;<br>

<h4> 2 - PREENCHE_CAMP_CLIENT </h4>
<h5> Funcionalidade: Preenche campos status cliente para 'A = Ativo' e Data criação / alteração. </h5>

<h4> Código:</h4>
create or replace trigger PREENCHE_CAMP_CLIENTE<br>
after INSERT on cliente<br>
DECLARE<br>
    vid_cliente cliente.id_cliente%type;<br>
BEGIN<br>
    select MAX(id_cliente) into vid_cliente from cliente;<br>
    UPDATE CLIENTE SET STATUS_CLIENTE = 'A',DATA_CADASTRO = SYSDATE, DATA_ALTERACAO = SYSDATE WHERE id_cliente = vid_cliente;<br>
END;<br>


<h3>Sequences: </h3>

SEQ_CLIENTE, SEQ_CONTA e SEQ_ENDERECO<br>
Funcionalidade: Responsável por inserir ID's automaticamente. <br> <br>

1 - create sequence SEQ_CLIENTE start with 1; <br>
2 - create sequence SEQ_CONTA start with 1; <br>
3 - create sequence SEQ_ENDERECO start with 1; <br>