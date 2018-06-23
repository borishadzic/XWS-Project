using AdminFront.Pages;
using AdminFront.Requests;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace AdminFront
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
       
        Window1 siw ;
        FilteView fv;
        public MainWindow()
        {
            siw = new Window1(this);
            siw.Show();
            InitializeComponent();
            this.Hide();
            DataContext = this;
        }

        public void ClientClick(object sender, RoutedEventArgs args)
        {
            this.PrimaryFrame.Content = new ClientView();
        }

        public void DataClick(object sender, RoutedEventArgs e)
        {
            this.PrimaryFrame.Content = new FilteView();
        }
        
<<<<<<< HEAD
        public void AgentClick(object sender, RoutedEventArgs e)
        {
            this.PrimaryFrame.Content = new CommentView();
        }
=======
>>>>>>> branch 'master' of https://github.com/borishadzic/XWS-Project.git

    }
}
