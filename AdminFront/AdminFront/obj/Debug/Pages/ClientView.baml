   M S B A M L   `   `   `  ����E  AAdminFront, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null3clr-namespace:AdminFront.PagesAdminFront.Pages  5      !    AdminFront.Pages.ClientView   5      W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      0localclr-namespace:AdminFront.Pages     5      
�������.��5
      �   � RowDefinitions  5   
   �� 5      $
��auto �6   �� 5      $��* �6   .+�5   
   �� -   5        $��ListaKlijenata��5      $��1��6)    �� View 5      �� 5      .P�5      �� $��email��6%    �� Width$	 150��64    �� DisplayMemberBinding 6@   �� *
username+�� 5      $��authorities��6%   $	 150��6:    �� CellTemplate 5      �� 5      .R�5   "   �� ��6+   �� *authorities+5      5      �� 5      $��
non_locked��6%   $	 150��69    5      �� 5      .R�5   "   �� ��5   &   �� 5   *    �� 
TargetType" ��60   .�5    .   ��  �� Property � �� �� Value$
 Left=�6T    �� Triggers 5!   .   �� 5"   2   	 �� Binding	 6>   �� 
 �� Path$
 	nonLocked� �� Value True6a   .a�5#   6   ��  � ��$ 	NonLocked��6M   5$   3   �� 5%   2   	 6>   �� $
 	nonLocked�	 False6a   .a�5&   6   ��  � ��$ Locked��6M   5'   3   5)   +   5+   #   5,      5.      5/      51      �� 52   
    �� Orientation$ 
Horizontal=�6   $��0��6.   .+�53      �� $%��Change selected account status:��6   �� 54      $��20��6   �� 55      -   5        $��Change Status��55      6-   56      57      58      