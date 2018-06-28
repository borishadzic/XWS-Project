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
using System.Windows.Threading;

namespace AdminFront
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private ClientView clientv;
        private CommentView commentv;
        private FilteView filev;
        private ClientRequests cr;

        public MainWindow()
        {
            cr = new ClientRequests();
            commentv = new CommentView();
            filev = new FilteView();
            clientv = new ClientView();
            InitializeComponent();
            DataContext = this;
        }

        
        

        public void ClientClick(object sender, RoutedEventArgs args)
        {
            clientv.Refresh();
            this.PrimaryFrame.Content = clientv;
        }

        public void DataClick(object sender, RoutedEventArgs e)
        {
            filev.Refresh();
            this.PrimaryFrame.Content = filev;
        }
        
        public void AgentClick(object sender, RoutedEventArgs e)
        {
            commentv.Refresh();
            this.PrimaryFrame.Content = commentv;
        }

        public void RefreshSources(object sender, RoutedEventArgs e)
        {
            clientv.Refresh();
            commentv.Refresh();
            filev.Refresh();
        }

        public void setOneMinute(object sender, RoutedEventArgs e)
        {
            filev.SetRefreshTime(1);
            commentv.SetRefreshTime(1);
            clientv.SetRefreshTime(1);
        }

        public void setFiveMinutes(object sender, RoutedEventArgs e)
        {
            filev.SetRefreshTime(5);
            commentv.SetRefreshTime(5);
            clientv.SetRefreshTime(5);
        }

        public void setTenMinutes(object sender, RoutedEventArgs e)
        {
            filev.SetRefreshTime(10);
            commentv.SetRefreshTime(10);
            clientv.SetRefreshTime(10);
        }

        public void setFifteenMinutes(object sender, RoutedEventArgs e)
        {
            filev.SetRefreshTime(15);
            commentv.SetRefreshTime(15);
            clientv.SetRefreshTime(15);
        }

        public void setThirtyMinutes(object sender, RoutedEventArgs e)
        {
            filev.SetRefreshTime(30);
            commentv.SetRefreshTime(30);
            clientv.SetRefreshTime(30);
        }

        public void setSixtyMinutes(object sender, RoutedEventArgs e)
        {
            filev.SetRefreshTime(60);
            commentv.SetRefreshTime(60);
            clientv.SetRefreshTime(60);
        }
    }
}
