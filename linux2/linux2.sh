#!/bin/bash
scp -v dir1/filename username@l-test.dev.cn1:/tmp

#�����﷨�� 
# scp [����] source target

#�������� 
#-v �� ��ʾ���ȣ����������鿴���ӡ���֤�������ô���
#-r �� ��ֵĿ¼
#-C ��ʹ��ѹ��ѡ�� 
#-P ��ѡ��˿�
#-4 �� ǿ��ʹ�� IPV4 ��ַ
#-6 �� ǿ��ʹ�� IPV6 ��ַ

#������ʹ�÷�ʽ��
#�����ظ��Ƶ�Զ��
# scp local_file remote_username@remote_ip:remote_folder
# scp local_file remote_username@remote_ip:remote_folder/remote_file
# scp local_file remote_ip:remote_folder
# scp local_file remote_ip:remote_folder/remote_file