# JavaPcontroleDR

<h1>Projeto Java Controle de Receita e Dispesa</h1>

<h2>Padrão utilizado no projeto JAVA: </h2>
1 - MVC
2 -  JFrame Form

<h2>Procedimentos utilizado no banco de dados Oracle: </h2>

<h3>PL/SQL: Responsável por gerar um arquivo txt. da tabela log preenchida. </h3>

<h4>Código: </h4>
DECLARE
 arquivo_saida UTL_File.File_Type;
 Cursor Cur_Linha is
 SELECT USUARIO, HORARIO, VALOR_ANTIGO, VALOR_NOVO FROM LOG; 
BEGIN
 arquivo_saida := UTL_File.Fopen('DIRETORIO','Lista.txt','w');
 For Reg_Linha in Cur_linha Loop
 UTL_File.Put_Line(arquivo_saida, Reg_linha.USUARIO||';'||Reg_linha.HORARIO||';'||Reg_linha.VALOR_ANTIGO||';'||Reg_linha.VALOR_NOVO);
 End Loop;
 UTL_File.Fclose(arquivo_saida);
 Dbms_Output.Put_Line('Arquivo gerado com sucesso.');
EXCEPTION
 WHEN UTL_FILE.INVALID_OPERATION THEN
 Dbms_Output.Put_Line('Operação inválida no arquivo.');
 UTL_File.Fclose(arquivo_saida);
 WHEN UTL_FILE.WRITE_ERROR THEN
 Dbms_Output.Put_Line('Erro de gravação no arquivo.');
 UTL_File.Fclose(arquivo_saida);
 WHEN UTL_FILE.INVALID_PATH THEN
 Dbms_Output.Put_Line('Diretório inválido.');
 UTL_File.Fclose(arquivo_saida);
 WHEN UTL_FILE.INVALID_MODE THEN
 Dbms_Output.Put_Line('Modo de acesso inválido.');
 UTL_File.Fclose(arquivo_saida);
 WHEN Others THEN
 Dbms_Output.Put_Line('Problemas na geração do arquivo.');
 UTL_File.Fclose(arquivo_saida);
END;

<h3>Trigger's:</h3>
1 -  GERA_LOG_ALT
<h4> Funcionalidade: Monitora alteração feita no campo class da tabela cliente.</h4>

<h4> Código: </h4>
create or replace TRIGGER GERA_LOG_ALT
AFTER UPDATE OF CLASSE ON CLIENTE FOR EACH ROW
DECLARE
BEGIN
       INSERT INTO LOG (USUARIO,HORARIO,VALOR_ANTIGO, VALOR_NOVO)
        VALUES (USER,SYSDATE,:OLD.CLASSE, :NEW.CLASSE);
END;

2 - PREENCHE_CAMP_CLIENT
<h4> Funcionalidade: Preenche campos status cliente para 'A = Ativo' e Data criação / alteração. </h4>

<h4> Código:</h4>
create or replace trigger PREENCHE_CAMP_CLIENTE
after INSERT on cliente
DECLARE
    vid_cliente cliente.id_cliente%type;
BEGIN
    select MAX(id_cliente) into vid_cliente from cliente;
    UPDATE CLIENTE SET STATUS_CLIENTE = 'A',DATA_CADASTRO = SYSDATE, DATA_ALTERACAO = SYSDATE WHERE id_cliente = vid_cliente;
    COMMIT;
END;


<h3>Sequences: </h3>

SEQ_CLIENTE, SEQ_CONTA e SEQ_ENDERECO
Funcionalidade: Responsável por inserir ID's automaticamente. 

1 - create sequence SEQ_CLIENTE start with 1; 
2 - create sequence SEQ_CONTA start with 1; 
3 - create sequence SEQ_ENDERECO start with 1; 