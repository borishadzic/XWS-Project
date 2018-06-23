using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
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
using System.Windows.Shapes;
using System.IdentityModel.Tokens;
using AdminFront.Requests;

namespace AdminFront
{
    /// <summary>
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class Window1 : Window,INotifyPropertyChanged
    {
        private string _username;
        private string _password;

        private MainWindow mw;


        public string username
        {
            get
            {
                return this._username;
            }
            set
            {
                this._username = value;
                OnNotifyPropertyChanged("username");
            }
        }

        public string password
        {
            get
            {
                return this._password;
            }
            set
            {
                this._password = value;
                OnNotifyPropertyChanged("password");
            }
        }

        public static HttpClient client;

        public event PropertyChangedEventHandler PropertyChanged;

        public Window1(MainWindow mw)
        {
            this.mw = mw;
            InitializeComponent();
            DataContext = this;
            
        }

        public void OnNotifyPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            var response = ClientRequests.SignIn(UserName.Text, Password.Password);
            if (response == null)
            {
                MessageBox.Show("Wrong emmail or password");
            }
            else
            {
                this.Close();
                mw.Show();
            }

            
        }

        protected override void OnClosing(System.ComponentModel.CancelEventArgs e)
        {
            if(ClientRequests.token == "")
                mw.Close();
            base.OnClosing(e);
            
        }
    }
}
