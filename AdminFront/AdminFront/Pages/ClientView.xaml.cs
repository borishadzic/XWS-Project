using AdminFront.DTOs;
using AdminFront.Requests;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
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

namespace AdminFront.Pages
{
    /// <summary>
    /// Interaction logic for ClientView.xaml
    /// </summary>
    public partial class ClientView : UserControl
    {
        private DispatcherTimer dt;

        private List<ProfileDTO> clients ;

        
        public ClientView()
        {
            dt = new DispatcherTimer();
            dt.Tick += new EventHandler(AutoRefresh);
            dt.Interval = new TimeSpan(0, 5, 0);
            dt.Start();
            InitializeComponent();
            clients = getClients();
            ListaKlijenata.ItemsSource = clients;

        }
        private void AutoRefresh(object sender, EventArgs args)
        {
            clients = getClients();
            ListaKlijenata.ItemsSource = clients;
        }

        public List<ProfileDTO> getClients()
        {
            return ClientRequests.getClients();
        }
        

        private void CheckBox_Checked(object sender, RoutedEventArgs e)
        {
            if (ListaKlijenata.SelectedItem == null)
            {
                MessageBox.Show("Please select a client");
                return;
            }
            var klient = clients.ElementAt(ListaKlijenata.SelectedIndex);

            var client = ClientRequests.toogleLockedUser(klient);
        }

        private void CheckBox_Checked2(object sender, RoutedEventArgs e)
        {
            if (ListaKlijenata.SelectedItem == null)
            {
                MessageBox.Show("Please select a client");
                return;
            }
            var klient = clients.ElementAt(ListaKlijenata.SelectedIndex);
            ProfileDTO client;
            if (klient.nonLocked)
            {
                client = ClientRequests.toogleLockedUser(klient);
            }
            else
            {

                client = ClientRequests.toogleLockedUser2(klient);
            }
            clients = ClientRequests.getClients();
            ListaKlijenata.ItemsSource = clients;
            
        }

        
    }
}
