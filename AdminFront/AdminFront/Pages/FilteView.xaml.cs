using AdminFront.DTOs;
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

namespace AdminFront.Pages
{
    /// <summary>
    /// Interaction logic for FilteView.xaml
    /// </summary>
    /// 


    public partial class FilteView : UserControl
    {
        private DispatcherTimer dt;

        private FilterDTO filter = new FilterDTO();
        public FilteView()
        {
            InitializeComponent();
            dt = new DispatcherTimer();
            dt.Tick += new EventHandler(AutoRefresh);
            dt.Interval = new TimeSpan(0, 5, 0);
            dt.Start();
            filter = ClientRequests.getFilters();
            TypeList.ItemsSource = filter.types.Select(x=> x.type);
            CatagoryList.ItemsSource = filter.categories.Select(x=> x.category);
            ServicesList.ItemsSource = filter.services.Select(x=> x.name);
            DataContext = this;
        }

        private void AutoRefresh(object sender, EventArgs args)
        {
            Refresh();
        }

        public void SetRefreshTime(int minutes)
        {
            dt.Interval = new TimeSpan(0, minutes, 0);
        }

        public void Refresh()
        {

            filter = ClientRequests.getFilters();
            TypeList.ItemsSource = filter.types.Select(x => x.type);
            CatagoryList.ItemsSource = filter.categories.Select(x => x.category);
            ServicesList.ItemsSource = filter.services.Select(x => x.name);
        }

        public void addType(object sender, RoutedEventArgs arg)
        {
            
            if (NewType.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.addType(NewType.Text);
            filter = ClientRequests.getFilters();
            TypeList.ItemsSource=filter.types.Select(x=>x.type);
            
        }

        public void addService(object sender, RoutedEventArgs arg)
        {
            if (NewService.Text=="")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.addService(NewService.Text);
            filter = ClientRequests.getFilters();
            ServicesList.ItemsSource = filter.services.Select(x => x.name);
        }
        public void addCatagory(object sender, RoutedEventArgs arg)
        {
            if (NewCatagory.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.addCatagory(NewCatagory.Text);
            filter = ClientRequests.getFilters();
            CatagoryList.ItemsSource = filter.categories.Select(x=> x.category);
        }


        public void modifyType(object sender, RoutedEventArgs arg)
        {
            if (TypeList.SelectedItem == null)
            {
                MessageBox.Show("Please select Type to change");
                return;
            }
            if (ModifyType.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.modifyType((String)TypeList.SelectedItem, ModifyType.Text);
            filter = ClientRequests.getFilters();
            TypeList.ItemsSource = filter.types.Select(x => x.type);
        }

        public void modifyService(object sender, RoutedEventArgs arg)
        {
            if (ServicesList.SelectedItem == null)
            {
                MessageBox.Show("Please select Service to change");
                return;
            }
            if (ModifyService.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.modifyService((String)ServicesList.SelectedItem, ModifyService.Text);
            filter = ClientRequests.getFilters();
            ServicesList.ItemsSource = filter.services.Select(x => x.name);
        }

        public void modifyCategory(object sender, RoutedEventArgs arg)
        {
            if (CatagoryList.SelectedItem == null)
            {
                MessageBox.Show("Please select Catagory to change");
                return;
            }
            if (ModifyCategory.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.modifyCategory((String)CatagoryList.SelectedItem, ModifyCategory.Text);
            filter = ClientRequests.getFilters();
            CatagoryList.ItemsSource = filter.categories.Select(x => x.category);
        }
    }
}
